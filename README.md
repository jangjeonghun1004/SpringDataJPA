# JPA

    JPA(Java Persistence API)는 
    자바 애플리케이션에서 관계형 데이터베이스를 보다 쉽게 관리할 수 있도록 도와주는 표준 API입니다. 
    즉, 자바 객체를 데이터베이스 테이블에 매핑하고, 그 테이블과 데이터를 연동하는 작업을 간편하게 처리할 수 있게 해줍니다. 
    이를 통해 SQL을 직접 작성하지 않고도 데이터베이스와 상호작용할 수 있습니다.

# Spring Data JPA

    Spring Data JPA는 JPA(Java Persistence API)를 더욱 쉽게 사용하기 위해 만들어진 스프링 프레임워크의 하위 프로젝트입니다. 
    JPA는 자바 객체와 데이터베이스 간의 매핑을 자동화하고, 이를 통해 복잡한 SQL 없이 데이터베이스와 상호작용할 수 있게 해주는데, 
    Spring Data JPA는 이 JPA를 더 효율적으로 사용할 수 있도록 추가적인 기능과 편리한 API를 제공합니다.

# Spring Data JPA의 주요 특징

    1. Repository 인터페이스 기반
    2. 자동으로 SQL 생성
    3. 페이징 및 정렬 지원
    4. @Query를 통한 사용자 정의 쿼리
    5. @Transactional을 통한 트랜잭션 처리

# Spring Data JPA을 위한 의존성(Dependency)

    Spring Configuration processor
    Spring Data JPA
    MySQL Driver

# application.properties 설정

    spring.datasource.url=jdbc:mysql://127.0.0.1:3306/spring
    spring.datasource.username=root
    spring.datasource.password=root
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

    * spring.jpa.hibernate.ddl-auto 옵션
        개발 환경 = create 또는 update
        운영 환경 = validate 또는 none

# 애플리케이션의 구조

![SpringDataJPA Process.png](SpringDataJPA%20Process.png)

    DTO(Data Transfer Object)
    클라이언트, 컨트롤러, 서비스 간의 데이터 전송을 위한 객체

    DAO(Data Access Object)
    데이터베이스 접근을 위한 객체

    Entity
    데이터베이스의 Data Relation을 위한 객체

# JpaRepository 기본 메소드

    productRepository.save(product)
    productRepository.getReferenceById(number)
    productRepository.findAll()
    productRepository.findAll(Sort.by(Sort.Direction.DESC, "number"))
    productRepository.findAll(PageRequest.of(pageNumber, pageSize))
    productRepository.delete(product)

# Repository

    JpaRepository
    https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html

    CrudRepository
    https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html

    ListCrudRepository
    https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/ListCrudRepository.html

    ListPagingAndSortingRepository
    https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/ListPagingAndSortingRepository.html

    PagingAndSortingRepository
    https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/PagingAndSortingRepository.html

    QueryByExampeExecutor
    https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/query/QueryByExampleExecutor.html






