#!bin/bash

function help_and_exit() {
	echo -e "Usage: psstat [OPTION] ...\nList process information.\nOptions are";
	echo -e "--list-short\t\t\t\t\tlist all processes in short format";
	echo -e "--list-long\t\t\t\t\tlist all processes in long format";
	echo -e "--list-name-has <name_part>\t\t\tlist all processes whose name has name_part in long format";
	echo -e "--list-pid-is <pid>\t\t\t\tlist status of the process whose pid is <pid>";
	echo -e "--list-schedu-policy-is <policy_number>\t\tlist all processes whose CPU scheduling policy number is <policy_number> in long format";

	exit 1;
}
