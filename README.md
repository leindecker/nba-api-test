
# APi Test for gorest public API




## Authors

- [@Guilherme Leindecker](https://github.com/leindeckere)


## Run Locally

Clone the project

```bash
  git clone https://github.com/leindecker/nba-api-test
```

Go to the project directory

```bash
  cd my-project
```

Run tests with Maven

```bash
  mvn test -Dcucumber.filter.tags="${CUCUMBER_TAG}"
```

Every push to a new branch or Pull Request to branhc [origin/main] will trigger CI/CD Github Actions

Allure Reportare generate at the URL below:

https://leindecker.github.io/nba-api-test/

## Allure Reports - Locally

Run below command on command prompt or terminal with the following command
```bash
  allure serve
```

## Tech Stack

**Project:** Java, Cucumber, restAssured, GitHub Actions

