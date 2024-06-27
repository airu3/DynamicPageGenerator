# buildステージを開始、Eclipse Temurin 17 JDKを適応したMavenということを設定
FROM maven:3-eclipse-temurin-17 AS build 
# 現在のディレクトリをコンテナの中のappディレクトリにコピー
COPY . . 
# アプリケーションの実行と、テストのスキップ。
RUN mvn clean package -Dmaven.test.skip=true
# 新しいビルドステージの開始
FROM eclipse-temurin:17-alpine
# 前のビルドステージからビルドされたjarファイル(dpgApp.jar)を新しいビルドステージにコピー
COPY --from=build /target/DynamicPageGenerator-0.0.1-SNAPSHOT.jar dpgApp.jar 
# ポート8080を宣言
EXPOSE 8080
# 実行するファイル(dpgApp.jar)を指定
ENTRYPOINT ["java", "-jar", "dpgApp.jar"]
