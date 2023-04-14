while True:
    w = input()
    temp = []
    if w == '.':
        #print("ASDASD")
        break

    for a in w:
        if '(' == a or '[' ==a :
            temp.append(a)

        elif a == ')':
            if len(temp) != 0 and '(' == temp[-1]:
                temp.pop(-1)

            else:
                temp.append(a)
                break

        elif a == ']':
            if len(temp) != 0 and '[' == temp[-1]:
                temp.pop(-1)
            else:
                temp.append(a)
                break

    if not temp:
        print('yes')
    else:
        print('no')
