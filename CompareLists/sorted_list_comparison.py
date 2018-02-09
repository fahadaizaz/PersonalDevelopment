def __create_matrix(input_file):
    i = 0
    m = []
    with open(input_file) as inp:
        for line in inp:
            m.append([])
            m[i] = [x.strip() for x in line.split('\t')]
            i = i + 1
    return m


def __create_list(input_file):
    with open(input_file) as inp:
        lines = inp.readlines()
    lines = [x.strip() for x in lines]
    return lines


def search(dump_file, source_file):
    dump_matrix = __create_matrix(dump_file)
    source_list = __create_list(source_file)

    found = []
    not_found = []
    offset = 0
    for x in range(0, len(source_list)):
        flag_found = 0
        for y in range(offset, len(dump_matrix)):
            if source_list[x] == dump_matrix[y][0]:
                flag_found = 1
                found.append(','.join(dump_matrix[y]) + '\n')
                offset = y
                break

        if flag_found == 0:
            not_found.append(source_list[x] + '\n')

    return found, not_found
