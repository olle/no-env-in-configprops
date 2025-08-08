.PHONY: all
all:
	MY_PROPS_0_NAME=Fred MY_PROPS_0_AGE=44\
 MY_PROPS_1_NAME=Joe MY_PROPS_1_AGE=22\
 ./mvnw -DskipTests spring-boot:run
	./mvnw verify

