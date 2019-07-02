# Spring FW

Reduces amount of codes required and allows easy accesses for maintenance

Web server programming - Spring MVC
										 --  Spring IoC (Spring DI)

Content Order

1. Spring IoC
2. Spring MVC
3. MyBatis

----------------------------------------------------------------------------------------------------------------------------------------------------------------

## 2019-06-27

(1) Spring IoC

```
1. Create Java Project, springioc
2. Creating a project means setting a proper environment for programming under certain programming
    languages
3. Since Java project does not have necessary environment for spring, it requires to install
   libraries
  - preparing additional libraries
  - download libraries (xxx.jar format files) from website and plug into required directories or set 	 path to allow access libraries
  - install tool that maintains libraries that will be installed (build tool)
    - Maven (pom.xml)
      - on Java Project's configuration setting, click 'Convert to Maven'
    - 그래들
4. In pom.xml project, added required libraries by utilizing "dependancy"
5. Spring IOC : Creates objects externally from Spring Container (Spring IoC Container / Spring DI 				   Container)
5. constructor-arg = Creating default object
6. property = setting index (values) which can have defaults but not required
7. Object that Spring Container maintains are Singleton pattern in default
	- If wish to parse singleton, by ( scope = "protype" ), it can be overided
8. UserService.class => loading class as object
9. In order to identify factory class, it must include following
	- the class property has to be static
10. xmlns:p="http://www.springframework.org/schema/p" == replace "property" tag with p:
11. xmlns:c="http://www.springframework.org/schema/c" == replace "constructor-arg" tag with c:
```

---------

## 2019-06-28

Framework == Smart Library

- Original Library requires to do what it exactly does
- Framework's smart library can make alterations when user needs to add / remove (make changes)
  - Library + Descriptor File (XML)
  - JAVA + XML => Use java when the page needs to have steady output, and use XML when the pages needs to be dynamic
- Variations
  - EJB, Servlet, Struts, MyBatis, Spring, Spring MVC (the one studying)
- In Spring annotation, @Autowired will be used more than often since it is designed only to use in Spring environment

```
@Autowired = "byType" : setter
1. Search by type and if type is just one, inject object
2. Search by type and if types are more than two, throws NoUniqueBeanDefinitionException
3. Serach by type and none is found returns null

@Autowired = "byName" : setter
1. Search for the same property name of the bean and inject object
2. If none is found, reutrns null
3. Before requesting properties injection, an object needs to be created which means empty
constructor

Setting @Autowired in fields
1. Search for type and if it has one then inject object
2. Search by type and if there are more than two types, then search by variable and id then
inject object

@Autowired = "constructor" : constructor
1. Search by type and if it has just one, inject object
2. Search by type and if there are more than two types, then search by variable and inject object
3. If none is found, returns null

@Resource



<context:component-scan base-package="sampleanno03"/> 
Spring scans if an annotation is existing inside the package by searching each class
	@Component("myFood")  //default : myFoodMgr
	public class MyFoodMgr{ 
	@Autowired
	//@Qualifier(value="unFavoriteFood")
	private Food favoriteFood;     // setter - Can be omitted
	@Autowired
	private Food unFavoriteFood;
@Component requests Spring to create the bean tag
@Autowired request Spring to create setter method
=> Search by type and if there are more than two types, then search by variable and inject object
@Qualifier(value="unFavoriteFood") Searches for the given value rather than setter which is 
private Food favoriteFood

In order to use annotation inside class, it has to have the source inside the package which means such as java.util.LocalDateTime cannot include annotaion since we do not have the actual source in the package



@Autowired can only be used in Spring FW
@Resource can be used in Java
1. 

If the source will be accesed with various framework, it is better to use @Resource than @Autowired, however, most of the framework is based on Spring, so many prefer @Autowired
```

# Spring MVC

Tier == Segregation in application by physical 

1. Client
2. Application Server
3. DB

Layer == Segregation in application by structure

1. Presentation Layer : Controller, View
2. Business Logic Layer : Service, Domain
3. DB Access Layer : DAO

By utilizing Spring, there is no need to create Servlet