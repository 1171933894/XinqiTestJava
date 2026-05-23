package org.example.service;

import jakarta.annotation.PostConstruct;
import org.example.model.TechStackCategory;
import org.example.model.TechStackItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechStackService {

    private final List<TechStackCategory> categories = new ArrayList<>();

    @PostConstruct
    public void init() {
        categories.add(TechStackCategory.builder()
                .name("前端技能")
                .items(List.of(
                        new TechStackItem("HTML5", "语义化标签与现代 Web 布局", "精通", ""),
                        new TechStackItem("CSS3", "Flexbox/Grid 布局、动画与响应式设计", "精通", ""),
                        new TechStackItem("JavaScript", "ES6+ 语法、异步编程", "熟练", ""),
                        new TechStackItem("React", "函数组件、Hooks、状态管理", "熟练", ""),
                        new TechStackItem("Vue.js", "Vue 3、Composition API", "了解", "")
                ))
                .build());

        categories.add(TechStackCategory.builder()
                .name("后端技能")
                .items(List.of(
                        new TechStackItem("Java", "Spring Boot、JPA、多线程", "精通", ""),
                        new TechStackItem("Python", "Flask、FastAPI、数据处理", "熟练", ""),
                        new TechStackItem("Node.js", "Express、NestJS 框架", "了解", ""),
                        new TechStackItem("SQL", "MySQL、PostgreSQL 数据库设计与优化", "熟练", ""),
                        new TechStackItem("Redis", "缓存、分布式锁", "熟练", "")
                ))
                .build());

        categories.add(TechStackCategory.builder()
                .name("DevOps 与工具")
                .items(List.of(
                        new TechStackItem("Docker", "容器化部署、Docker Compose", "熟练", ""),
                        new TechStackItem("Git", "版本控制、分支策略", "精通", ""),
                        new TechStackItem("Maven", "项目构建、依赖管理", "精通", ""),
                        new TechStackItem("Linux", "服务器运维、Shell 脚本", "熟练", ""),
                        new TechStackItem("CI/CD", "Jenkins、GitHub Actions", "了解", "")
                ))
                .build());

        categories.add(TechStackCategory.builder()
                .name("数据库与中间件")
                .items(List.of(
                        new TechStackItem("MySQL", "关系型数据库设计与优化", "熟练", ""),
                        new TechStackItem("PostgreSQL", "高级查询与扩展功能", "熟练", ""),
                        new TechStackItem("RabbitMQ", "消息队列、异步处理", "了解", ""),
                        new TechStackItem("Elasticsearch", "全文搜索与分析", "了解", "")
                ))
                .build());
    }

    public List<TechStackCategory> getCategories() {
        return categories;
    }
}
