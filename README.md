# springboot-jpa-demo

This project demonstrates `One-To-Many` and `Many-To-One` relation between two entities using `spring boot` and `Spring Data JPA`.

## What should I take notes
### 1. Auditing
- with Hibernate:
  + use `@CreationTimestamp` and `@UpdateTimestamp` on Entity column
- with Spring Data JPA:
  + use `@CreatedDate` and `@LastModifiedDate` on Entity column
  + use `@EntityListeners(AuditingEntityListener.class)` on Entity
  + use `@EnableJpaAuditing` on Main class

Example with Hibernate:
```java
  @Column(nullable = false, updatable = false)
  @CreationTimestamp
  private Date createdDate;

  @Column
  @UpdateTimestamp
  private Date lastModifiedDate;
```
