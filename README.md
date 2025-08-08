BUG: Unable to test ENV values as configprops

This is a setup that shows how tests using the `ApplicationContextRunner`
does not provide capabilities enough to assert that ENV variables are being
bound to custom configuration properties type that is wrapping a list of
record entries.

However, running the actual Spring Boot application will show that the ENV
variable values are bound to the configuration properties just fine.

```sh
> make # run app with ENV values and then tests
```

Works in the runtime. Broken in testing.

**How can this be fixed?**

_All work and no green tests makes Homer something-something. Go crazy?
Don't mind if a do!_

