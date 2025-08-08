.PHONY: all
all:
	MY_PROPS_0_NAME=Fred MY_PROPS_0_AGE=44 ./mvnw -DskipTests spring-boot:run
	./mvnw verify

