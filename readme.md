Some of my colleagues asked me what is spring-boot and what are the difference with spring.
This question also asked by some of them who already used spring in their projects. I told them
Spring-boot is just Spring with extra magics. To understand how the magics work,
I come up with the story where there are two developers Jeff and Jim whose working on the same project with different approach.
Jim is Senior Developer who used spring for years and Jeff is Junior Developer who just used spring.
Both of them were assigned to create simple application that can write a report to the console.
Jeff decide to create the application with spring while Jim is using spring-boot. Lets take a look at their code

Jeff's Code:
```
/**
 * @author Jeff
 */
@SpringBootApplication
public class Application implements CommandLineRunner{

    @Autowired
    private ReportWriter reportWriter;

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> datas = Arrays.asList("Data1", "Data2", "Data3");
        reportWriter.write(datas);
    }
}
```
Jim's code:
```
/**
 * @author Jim
 */
@Configuration
@ComponentScan(basePackages = "com.github.ktarou.blogs")
public class Application implements ApplicationRunner{

    @Autowired
    private ReportWriter reportWriter;

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        context.getBean(ApplicationRunner.class).run(args);
    }

    @Override
    public void run(String... args) {
        List<String> datas = Arrays.asList("Data1", "Data2", "Data3");
        reportWriter.write(datas);
    }
}

interface ApplicationRunner{
    void run(String... args);
}
```