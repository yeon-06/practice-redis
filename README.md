# Redis 학습용 레포지토리

## 💻 로컬에 Redis 설치하기

> 참고
> - [redisGate - Docker Redis 시작하기](http://redisgate.kr/redis/education/docker_intro.php)  
> - [yoojkim 블로그 - local에서 Redis 사용하기 / Docker 사용하여 Redis server 접속](https://velog.io/@yoojkim/Redis-local%EC%97%90%EC%84%9C-Redis-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0-Docker-%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC-Redis-server-%EC%A0%91%EC%86%8D)

#### 1. Docker 설치

- 설치 링크: https://docs.docker.com/desktop/install/mac-install/

#### 2. image 받아오기

```
docker image pull redis
```

#### 3. network 생성

- Redis-cli를 함께 사용하기 위해 2개의 컨테이너를 실행할 예정
- 2개의 컨테이너의 연결을 위한 네트워크

```
docker network create <네트워크명>
```

#### 4. Redis 실행

```
docker run --name <컨테이너명> -p <포트번호>:<포트번호> --network <네트워크명> -v redis_temp:/data -d redis:latest redis-server --appendonly yes
```

```
docker run --name local-redis -p 6379:6379 --network redis-network -v redis_temp:/data -d redis:latest redis-server --appendonly yes
```

- 로컬의 redis_temp와 docker의 /data 연결
- redis:latest image를 사용하여 백그라운드에서 서버 실행

#### 5. Redis-cli 접속

```
docker run -it --network <네트워크명> --rm redis:latest redis-cli -h <컨테이너명>
```

```
docker run -it --network redis-network --rm redis:latest redis-cli -h local-redis
```

## 📢 Redis-cli 간단한 명령어

- Redis는 String, Bitmaps, List, Hash, Set, Stream 등 여러 타입이 존재한다.
- 특정 데이터의 type을 조회하려면 아래 명령어를 실행한다.

```
type <key이름>
```

### String

- 데이터 저장

```
# 단건
set <key> <value>

# 여러개
mset <key> <value> <key> <value> ...

# key가 존재하지 않는 경우에만 저장
setnx <key> <value>

# 기존 데이터 조회 및 새 데이터 저장
getset <key> <value>
```

- 데이터 조회

```
# 단건
get <key>

# 여러개
mget <key> <key> <key> ...
```

### List

- 데이터 저장

```
# 리스트의 오른쪽에 데이터 저장
lpush <key> <value> <value...>

# 리스트의 왼쪽에 데이터 저장
rpush <key> <value> <value...>

# 특정 위치(인덱스) 값 변경
lset <key> <index> <value>
```

- 데이터 조회

```
# 오른쪽에서 데이터 조회 후 삭제
rpop <key>

# 왼쪽에서 데이터 조회 후 삭제
lpop <key>

# 특정 위치(인덱스) 값 조회
lindex <key> <index>
```

### Hash

- 데이터 저장

```
hset <key> <field> <value>
```

- 데이터 조회

```
hget <key> <field>

# key의 모든 field 이름 조회
hkeys <key>

# key의 모든 value 조회
hvales <key>

# key의 모든 field와 value 조회
hgetall <key>
```

### Set

- sorted set의 경우에는 명령어의 앞글자를 `s` -> `z`로 변경하면 된다.


- 데이터 저장

```
sadd <key> <member> <member...>
```

- 데이터 조회

```
smembers <key>

# member가 존재하는지 확인
sismember <key> <member>
```
