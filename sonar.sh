cd parent
mvn clean verify sonar:sonar \
  -Dsonar.projectKey=springboot_template \
  -Dsonar.projectName='springboot_template' \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.token=sqp_07767b8e119cd4883495bd227ec680fb7a734307
