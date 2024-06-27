FROM maven:3-eclipse-temurin-17 AS build //buildステージを開始、Eclipse Temurin 17 JDKを適応したMavenということを設定
COPY . . //ファイルをコピー
RUN mvn clean package -Dmaven.test.skip=true //アプリケーションの実行と、テストのスキップ。
FROM eclipse-temurin:17-alpine //新しいビルドステージの開始
COPY --from=build /target/DynamicPageGenerator-0.0.1-SNAPSHOT.jar dpgApp.jar //前のビルドステージからビルドされたjarファイル(demo.jar)を新しいビルドステージにコピー
EXPOSE 8080 //ポート8080を宣言
ENTRYPOINT ["java", "-jar", "dpgApp.jar"] //実行するファイル(dpgApp.jar)を指定
