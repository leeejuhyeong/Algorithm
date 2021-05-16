def solution(brown, yellow):
    answer = []
    all = brown + yellow
    all_root = int(all**(1/2))
    answer = []

    for i in range(all_root, brown):
        if all % i == 0:
            temp = all // i
            if (temp-2) * (i -2) == yellow:
                answer.append(int(all/i))
                answer.append(i)
                break

    answer.sort(reverse=True)
    return answer

if __name__ == "__main__":
    brown = 50
    yellow = 22
    print(solution(brown, yellow))