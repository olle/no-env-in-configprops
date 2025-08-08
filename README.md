BUG: Unable to test ENV values as configprops

This show a setup where testing with `ApplicationContextRunner` does
not provide capabilities to ensure that ENV variables are being bound
to a list of custom configuration properties.

However, running the application will output the bound properties.

```sh
> make # run app with ENV values and then tests
```

The output shows that binding to the runtime works just fine, but that
testing is broken.

**How can this be fixed?**

_All work and no green tests makes Homer something-something. Go crazy?
Don't mind if a do!_

