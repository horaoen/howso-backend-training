---
marp: true
theme: uncover
header: '南京华苏科技'
footer: '06/25/2023 by 方浩冉'
paginate: true
---
## <!--fit --> 实习生培训——后端开发基础
##### [资料](https://www.aliyundrive.com/s/A1d5WDSfjqg)

---
## 摘要
- [基本开发环境](#基本开发环境)
- [版本控制工具](#版本控制工具) 
- [SQL基础](#sql基础)
- [Maven](#maven)
- [常用技术](#常用技术)
- [基本开发习惯](#基本开发习惯)
- [开发场景演练](#开发场景演练)

---
## 基本开发环境
- [终端](#终端)
- [Docker](#docker)
- [英语学习插件Relingo](#relingo)

---
### 终端

---
#### Windows
1. 微软商店安装windows terminal	

2. [安装新版powershell](https://learn.microsoft.com/zh-cn/powershell/scripting/install/installing-powershell?view=powershell-7.3)

   ```shell
   winget search Microsoft.PowerShell
   winget install --id Microsoft.Powershell --source winget
   ```

3. [安装scoop](https://scoop.sh/#/)

4. 使用scoop安装相关软件
---

   ```
   scoop bucket add java
   scoop install openjdk8-redhat
   scoop install git
   scoop install maven
   scoop install redis
   ```

#### Macos
<style scoped>
  ol {
    font-size: 30px
  }
</style>

1. [安装homebrew](https://brew.sh/index_zh-cn)
2. 安装软件
   ```shell
   brew install iterm2
   brew install zsh
   # 修改默认shell为zsh
   chsh -s /bin/zsh
   ```
3. [oh-my-zsh](https://ohmyz.sh/#install)

---
<style scoped>
  ol {
    font-size: 30px
  }
</style>
### Docker

1. [下载安装](https://www.docker.com/products/docker-desktop/)
2. [官网get-started文档](https://docs.docker.com/get-started/)
3. MySQL、Redis安装
   - [dockerhub](https://hub.docker.com/)
   - [mysql image](https://hub.docker.com/_/mysql)   
   - [redis image](https://hub.docker.com/_/redis)
   
```shell
docker run --name mysql8 -e MYSQL_ROOT_PASSWORD=123456 -p 3306:3306 -d mysql:latest
docker run --name redis -p 6379:6379 -d redis
```
---
### Relingo

---
![bg left fit](./img/relingo.png)
![width:600px](./img/relingo-translate.png)
---

---
## 版本控制工具
- [progit](#progit)
- [常用git命令总结](#常用Git命令总结)
- [IntelliJ IDEA中Git使用](#intellij-idea中git使用)

---
### progit
![width:1100px](img/git存储方式.png)
---

---
![width:1100px](img/git三种状态.png)
---

---
![width:1100px](img/git文件状态变化周期.png)
---

---
### 常用Git命令总结
<style scoped>
  section {
    font-size: 29px
  }
</style>
```shell
git congig --list
git config user.name

git clone <repo url>
git remote -a
git remote -v
git remote add <origin_name> <origin_url>
git remote remove <origin_name>

git checkout <branch_name>
git merge <branch_name>
git rebase <branch_name>

git push <branch_name>
git fetch <branch_name>

git pull <remote_origin_name> (<local_origin_name>) 
# 等效于 git fetch <remote_orgin_name> && git merge <remote_origin_name>
# <local_origin_name>不声明默认为当前操作分支
# eg：有两个分支dev、hotfix，当hotfix想要更新远程dev分支的代码时在hotfix分支执行：
# git pull dev相当于通过fetch更新remote:dev, 再通过merge 将remote:dev合并到local:hotfix上
```

---
### Intellij IDEA中Git使用
1. Local changes中对变更文件管理（rollback、show diff）
2. 代码更新
3. 代码提交
4. 代码合并
5. 解决代码冲突
---
## SQL基础

1. [Getting Started with MySQL Quickly (mysqltutorial.org)](https://www.mysqltutorial.org/getting-started-with-mysql/)
2. [MySQL Basics (mysqltutorial.org)](https://www.mysqltutorial.org/mysql-basics/)

---
## Maven

1. [baeldung maven category](https://www.baeldung.com/category/maven)
2. Maven guide 手册概览
3. IDEA 搜索依赖、maven配置镜像源

---
## 常用技术

1. [SpringBoot](#springboot)
2. [Mybatis Plus](#mybatis-plus)
3. [Hutool](#hutool)

---
### SpringBoot
1. SpringBoot reference guide

### Mybatis Plus
1. 文档概览
2. 条件构造器常见使用
3. 代码生成器

---
### hutool

---
## 基本开发习惯
---
## 开发场景演练