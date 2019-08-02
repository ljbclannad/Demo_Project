package com.example.demo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ：lejb
 * @date ：Created in 2019/8/2 15:54
 * @Description :Swagger接口生成工具配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 创建API应用
     * appinfo()增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例，用来控制那些接口暴露给Swagger来展现
     * 本例采用置顶扫描的包路径来定义指定要建立API的目录
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.swagger"))
                .paths(PathSelectors.any()).build();
        return docket;
    }


    /**
     * 创建改API的基本信息（这些基本信息会展示在文档页面中）
     * 访问地址： http://项目实际地址/swagger-ui.html
     * @return
     */
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger接口测试")
                .description("接口")
                .termsOfServiceUrl("http://www.baidu.com")
                .contact("lejb")
                .version("1.0")
                .build();
    }
}
