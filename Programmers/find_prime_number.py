from itertools import permutations

def solution(numbers):
    array1 = list(numbers)
    length = len(numbers)
    primeset = set()

    for i in range(1, length+1):
        arr = list(permutations(array1, i))
        for j in arr:
            temp = ''
            for k in j:
                temp += k
            temp = int(temp)
            count = 0
            if temp != 1 and temp != 0:
                for k in range(2, temp+1):
                    if count == 2:
                        break
                    if temp % k == 0:
                        count += 1
                if count == 1:
                    primeset.add(temp)
    answer = len(primeset)
    return answer

if __name__ == "__main__":
    numbers = "17"
    print(solution(numbers))