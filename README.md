# Redis 학습용 레포지토리

## 1. 로컬에 Redis 설치하기

> 참고
> - http://redisgate.kr/redis/education/docker_intro.php  
> - https://velog.io/@yoojkim/Redis-local%EC%97%90%EC%84%9C-Redis-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0-Docker-%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC-Redis-server-%EC%A0%91%EC%86%8D

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
docker network create {네트워크명}
```

#### 4. Redis 실행

```
docker run --name {컨테이너명} -p {포트번호}:{포트번호} --network {네트워크명} -v redis_temp:/data -d redis:latest redis-server --appendonly yes
```

```
docker run --name local-redis -p 6379:6379 --network redis-network -v redis_temp:/data -d redis:latest redis-server --appendonly yes
```

- 로컬의 redis_temp와 docker의 /data 연결
- redis:latest image를 사용하여 백그라운드에서 서버 실행

#### 5. Redis-cli 접속

```
docker run -it --network {네트워크명} --rm redis:latest redis-cli -h {컨테이너명}
```

```
docker run -it --network redis-network --rm redis:latest redis-cli -h local-redis
```
