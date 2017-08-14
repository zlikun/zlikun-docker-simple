# zlikun-docker-simple

Docker测试工程

#### `dockerfile-maven-plugin`插件
```
<!-- 与docker-maven-plugin插件不同，该插件只能使用Dockerfile构建 -->
<!-- Dockerfile固定放在工程根目录下，工程根目录即工作空间，所以Dockerfile中复制文件注意加上target目录 -->
<plugin>
    <groupId>com.spotify</groupId>
    <artifactId>dockerfile-maven-plugin</artifactId>
    <version>1.3.4</version>
    <configuration>
        <repository>zlikun/${project.build.finalName}</repository>
        <tag>1.0</tag>
    </configuration>
    <executions>
        <execution>
            <id>default</id>
            <goals>
                <goal>build</goal>
                <goal>push</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

#### 连接Redis容器
> 应用中指定Redis主机是，使用Redis容器名代替，Docker将自己搜索服务(两者在同一网络中)。