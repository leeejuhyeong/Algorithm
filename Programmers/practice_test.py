def solution(answers):
    answer = []
    lenth = len(answers)

    first, second, third = 0, 0, 0
    i = 1
    for k in answers:
        if i == 6:
            i = 1
        if i == k:
            first += 1
        i += 1

    second_flag = 0
    second_list = [1, 3, 4, 5]
    for i, k in enumerate(answers):
        if i % 2 == 0:
            if k == 2:
                second += 1
        else:
            if second_flag == 4:
                second_flag = 0
            if second_list[second_flag] == k:
                second += 1
            second_flag += 1

    third_flag = 0
    third_return = 0
    third_list = [3, 1, 2, 4, 5]

    for k in answers:
        if third_flag == 2:
            third_return += 1
            third_flag = 0
        if third_return == 5:
            third_return = 0
        if third_list[third_return] == k:
            third += 1
        third_flag += 1

    Q = [[first, 1], [second, 2], [third, 3]]
    Q.sort(key=lambda x:x[0], reverse=True)

    if Q[0][0] == Q[1][0]:
        if Q[0][0] == Q[2][0]:
            answer.append(Q[0][1])
            answer.append(Q[1][1])
            answer.append(Q[2][1])
        else:
            answer.append(Q[0][1])
            answer.append(Q[1][1])
    else:
        answer.append(Q[0][1])

    return answer


if __name__ == "__main__":
    answers = [1, 3, 2, 4, 2]
    print(solution(answers))
