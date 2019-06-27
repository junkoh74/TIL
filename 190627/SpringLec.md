# Spring FW

Reduces amount of codes required and allows easy accesses for maintenance

Web server programming - Spring MVC
										 --  Spring IoC (Spring DI)

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
10. xmlns:p="http://www.springframework.org/schema/p" == replace "property" tag
11. xmlns:c="http://www.springframework.org/schema/c" == replace "constructor-arg" tag
```

