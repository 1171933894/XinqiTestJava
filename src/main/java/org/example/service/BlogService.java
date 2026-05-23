package org.example.service;

import jakarta.annotation.PostConstruct;
import org.example.model.BlogPost;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BlogService {

    private final List<BlogPost> posts = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @PostConstruct
    public void init() {
        posts.add(BlogPost.builder()
                .id(idCounter.getAndIncrement())
                .title("Java 17 新特性实战")
                .summary("探索 Java 17 带来的密封类、模式匹配和记录类型等新特性，提升代码质量与开发效率。")
                .content("""
                        <h2>密封类（Sealed Classes）</h2>
                        <p>密封类允许你指定哪些类或接口可以扩展或实现它，使得继承体系更加可控。</p>
                        <pre><code>public sealed class Shape permits Circle, Rectangle, Triangle { }</code></pre>

                        <h2>模式匹配（Pattern Matching）</h2>
                        <p>instanceof 模式匹配让类型检查和类型转换合二为一，代码更加简洁。</p>
                        <pre><code>if (obj instanceof String s) {
                            System.out.println(s.length());
                        }</code></pre>

                        <h2>记录类型（Records）</h2>
                        <p>Record 是一种全新的数据类型，用于简洁地定义不可变数据载体。</p>
                        <pre><code>public record Point(int x, int y) { }</code></pre>
                        """)
                .author("管理员")
                .publishedDate(LocalDate.of(2026, 5, 1))
                .tags(List.of("Java", "Java 17", "教程"))
                .build());

        posts.add(BlogPost.builder()
                .id(idCounter.getAndIncrement())
                .title("Spring Boot 3 入门指南")
                .summary("从零开始学习 Spring Boot 3，了解自动配置、起步依赖和 Actuator 等核心概念。")
                .content("""
                        <h2>什么是 Spring Boot？</h2>
                        <p>Spring Boot 是 Spring 框架的扩展，旨在简化 Spring 应用的初始搭建和开发过程。</p>

                        <h2>核心特性</h2>
                        <ul>
                            <li><strong>自动配置</strong> — 根据类路径依赖自动配置 Spring 应用</li>
                            <li><strong>起步依赖</strong> — 一组便捷的依赖描述符</li>
                            <li><strong>Actuator</strong> — 提供生产级别的监控和管理能力</li>
                            <li><strong>嵌入式服务器</strong> — 内嵌 Tomcat、Jetty 等</li>
                        </ul>
                        """)
                .author("管理员")
                .publishedDate(LocalDate.of(2026, 4, 15))
                .tags(List.of("Spring Boot", "Java", "入门"))
                .build());

        posts.add(BlogPost.builder()
                .id(idCounter.getAndIncrement())
                .title("Maven 依赖管理最佳实践")
                .summary("总结 Maven 项目中的依赖管理技巧，包括版本管理、排除传递依赖和多模块项目配置。")
                .content("""
                        <h2>依赖版本集中管理</h2>
                        <p>使用 <code>&lt;dependencyManagement&gt;</code> 在父 POM 中统一管理版本号。</p>

                        <h2>排除不必要的传递依赖</h2>
                        <p>使用 <code>&lt;exclusions&gt;</code> 排除有冲突或不必要的传递依赖。</p>

                        <h2>多模块项目</h2>
                        <p>通过 <code>&lt;modules&gt;</code> 将大型项目拆分为多个模块，提升构建效率和代码复用。</p>
                        """)
                .author("管理员")
                .publishedDate(LocalDate.of(2026, 3, 20))
                .tags(List.of("Maven", "Java", "构建工具"))
                .build());

        posts.add(BlogPost.builder()
                .id(idCounter.getAndIncrement())
                .title("Docker 容器化部署实践")
                .summary("介绍如何使用 Docker 将 Java 应用容器化，并部署到服务器上。")
                .content("""
                        <h2>Dockerfile 编写</h2>
                        <p>使用多阶段构建来优化镜像体积。</p>
                        <pre><code>FROM eclipse-temurin:17-jre-alpine
        COPY target/app.jar app.jar
        ENTRYPOINT ["java", "-jar", "/app.jar"]</code></pre>

                        <h2>Docker Compose</h2>
                        <p>使用 Docker Compose 编排多个服务，如应用 + 数据库。</p>
                        """)
                .author("管理员")
                .publishedDate(LocalDate.of(2026, 2, 10))
                .tags(List.of("Docker", "DevOps", "部署"))
                .build());
    }

    public List<BlogPost> findAll() {
        return posts;
    }

    public Optional<BlogPost> findById(Long id) {
        return posts.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
}
