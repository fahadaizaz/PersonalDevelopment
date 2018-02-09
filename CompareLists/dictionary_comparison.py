def __create_dictionary(input_file):
    d = {}
    with open(input_file) as inp:
        for line in inp:
            key, value = line.split(None, 1)
            d[key] = line
    return d


def __create_list(input_file):
    with open(input_file) as inp:
        lines = inp.readlines()
    lines = [x.strip() for x in lines]
    return lines


def search(dump_file, source_file):
    dump_dict = __create_dictionary(dump_file)
    source_list = __create_list(source_file)

    found = []
    not_found = []
    for x in source_list:
        if x in dump_dict:
            found.append(dump_dict[x])
        else:
            not_found.append(x)

    return found, not_found


