#!/usr/bin/python

import argparse
import sorted_list_comparison as b

DEF_FOUND_FILE = 'found'
DEF_NOT_FOUND_FILE = 'not_found'


def parse_arguments():
    parser = argparse.ArgumentParser(description='Parse input arguments for comparison')
    parser.add_argument('-d', '--dumpfile', type=str, metavar='', required=True, help='database dump file with multiple columns')
    parser.add_argument('-s', '--sourcefile', type=str, metavar='', required=True, help='source file with single column')
    parser.add_argument('-y', '--foundfile', type=str, metavar='', required=False, help='output file containing items found')
    parser.add_argument('-n', '--notfoundfile', type=str, metavar='', required=False, help='output file containing items not found')
    return parser.parse_args()


def write_output(found_file, found_data, not_found_file, not_found_data):
    with open(found_file, 'w') as out:
        out.write(''.join(found_data))

    with open(not_found_file, 'w') as out:
        out .write(''.join(not_found_data))


if __name__ == '__main__':
    arguments = parse_arguments()
    found, not_found = b.search(arguments.dumpfile, arguments.sourcefile)

    if arguments.foundfile is None and arguments.notfoundfile is None:
        write_output(DEF_FOUND_FILE, found, DEF_NOT_FOUND_FILE, not_found)
    elif arguments.notfoundfile is None:
        write_output(arguments.foundfile, found, DEF_NOT_FOUND_FILE, not_found)
    elif arguments.foundfile is None:
        write_output(DEF_FOUND_FILE, found, arguments.notfoundfile, not_found)
    else:
        write_output(arguments.foundfile, found, arguments.notfoundfile, not_found)

