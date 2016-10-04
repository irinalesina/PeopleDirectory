# People

#### How to run:
1. Create MySQL database:
```sql
CREATE DATABASE people DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
```
2. Edit Liquibase properties file (resources/liquibase.properties) for your environment.
3. Apply database changes via script:
```
on Linux:    scripts/liquibase-run.sh
on Windows:  scripts/liquibase-run.bat
```