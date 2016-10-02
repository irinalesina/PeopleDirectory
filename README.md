# People

#### How to run:
1. Create MySQL database:
```sql
CREATE DATABASE people DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
```
2. Apply database changes via script:
```
on Linux:    scripts/liquibase-run.sh <db_username> <db_password>
on Windows:  scripts/liquibase-run.bat <db_username> <db_password>
```