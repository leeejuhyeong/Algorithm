def solution(answers):
    answer = []
    a = [1, 2, 3, 4, 5]
    b = [2, 1, 2, 3, 2, 4, 2, 5]
    c = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    score = [0, 0, 0]


    for idx, i in enumerate(answers):
        if i == a[idx % 5]:
            score[0] += 1
        if i == b[idx % 8]:
            score[1] += 1
        if i == c[idx % 10]:
            score[2] += 1

    for idx, i in enumerate(score):
        if i == max(score):
           answer.append(idx+1)

    return answer


if __name__ == "__main__":
    answers = [1, 3, 2, 4, 2]
    print(solution(answers))
