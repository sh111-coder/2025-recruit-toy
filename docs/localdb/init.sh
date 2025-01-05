#!/bin/bash
set -eu -o pipefail
cd -- "$(dirname "${BASH_SOURCE[0]}")"

main() {
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOF
	\i src/local_pg_init.sql

  \c toy_recruit_local
	\i src/set_up.sql

EOF

}

main "$@"
exit $?
