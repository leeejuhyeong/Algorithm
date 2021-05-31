def solution(begin, target, words):
    answer = [51]
    true = 0
    checklist = [0] * len(words)
    for word in words:
        if target == word:
            true += 1
    if true == 1:
        DFS(0, begin, target, words, checklist, answer)
        return answer[0]
    else:
        return 0


def DFS(level, begin, target, words, checklist, answer):
    if level > answer[0]:
        return
    if begin == target:
        if answer[0] > level:
            answer[0] = level
    for j in range(len(words)):
        if checklist[j] == 0:
            flag = conversion(begin, words[j])
            if flag == len(begin) - 1:
                checklist[j] = 1
                DFS(level + 1, words[j], target, words, checklist, answer)
                checklist[j] = 0


def conversion(a, b):
    A = list(a)
    B = list(b)
    cnt = 0

    for i, j in zip(A, B):
        if i == j:
            cnt += 1
    return cnt


if __name__ == "__main__":
    begin = "hot"
    target = "lot"
    words = ["hot", "dot", "dog", "lot", "log"]
    print(solution(begin, target, words))
