--@formatter:off

/**
 * Local PostgreSQL init
 *
 * <p>"boilerplate" 문자열을 해당 프로젝트명으로 일괄 치환하시면 됩니다.</p>
 */

/**
  * RDS 처럼 보이게 하기!
  */
CREATE ROLE "rds_superuser" WITH SUPERUSER;

GRANT "rds_superuser" TO postgres ;

CREATE USER "seongha_flyway";
ALTER USER "seongha_flyway" PASSWORD 'seongha123';

GRANT ALL PRIVILEGES ON SCHEMA public TO "seongha_flyway";
-- flyway service account timeout 설정
-- DDL 수행 특성상 타임아웃은 조금 높게 허용
ALTER USER "seongha_flyway" SET "idle_session_timeout" = '120s';
ALTER USER "seongha_flyway" SET "idle_in_transaction_session_timeout" = '120s';
ALTER USER "seongha_flyway" SET "statement_timeout" = '300s';
ALTER USER "seongha_flyway" SET "lock_timeout" = '30s';


--@formatter:off

/**
 * Local PostgreSQL init
 *
 * <p>"job" 문자열을 해당 프로젝트명으로 일괄 치환하시면 됩니다.</p>
 */


/**
  * role_PROJECT_operator: 해당 프로젝트의 관리 Role. 운영환경에서는 DBA 및 소수의 개발자에게만 부여.
  */
CREATE ROLE "role_recruit_operator" NOINHERIT;


CREATE DATABASE "toy_recruit_local"
    OWNER = "role_recruit_operator"
    TEMPLATE = "template0"
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C.UTF-8';

REVOKE ALL PRIVILEGES ON DATABASE "toy_recruit_local" FROM public;
GRANT CONNECT, CREATE, TEMPORARY ON DATABASE "toy_recruit_local" TO "role_recruit_operator";


GRANT "role_recruit_operator" TO "seongha_flyway";
ALTER USER "seongha_flyway" IN DATABASE "toy_recruit_local" SET role = 'role_recruit_operator';
