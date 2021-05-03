def solution(participant, completion):
    dic = {}

    # 해시 생성
    for i in participant:
        if i not in dic:
            dic[i] = 1
        else:
            dic[i] += 1

    for i in completion:
        dic[i] -= 1
        if dic[i] == 0:
            del dic[i]

    answer = list(dic.keys())
    return answer[0]

if __name__ == "__main__":
    participant = ["leo", "kiki", "eden"]
    completion = ["eden", "kiki"]

    print(solution(participant, completion))