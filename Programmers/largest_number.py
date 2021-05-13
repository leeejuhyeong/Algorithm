def solution(numbers):
    answer = ''

    zeros = []
    ones = []
    tens = []
    hundreds = []
    thousands = []

    for number in numbers:
        if number == 1000:
            thousands.append(number)
        if 100 <= number < 1000:
            temp = number // 100
            stemp = number % 100
            hundreds.append([temp, stemp // 10, stemp % 10, 1])
        if 10 <= number < 100:
            tens.append([number // 10, number % 10, number % 10, 2])
        if 0 < number < 10:
            ones.append([number, number, number, 3])
        if number == 0:
            zeros.append([number, number, number, 0])

    ones.sort(reverse=True)
    tens.sort(reverse=True)
    hundreds.sort(reverse=True)

    for i in range(9, 0, -1):
        temp = []
        for one in ones:
            if one[0] == i:
                temp.append(one)
        for ten in tens:
            if ten[0] == i:
                temp.append(ten)
        for hundred in hundreds:
            if hundred[0] == i:
                temp.append(hundred)

        temp.sort(key=lambda x:(x[3], x[1], x[2]), reverse=True)

        for tmp in temp:
            test = ''
            if tmp[3] == 1:
                for i in range(3):
                    test += str(tmp[i])
                answer += test
            elif tmp[3] == 2:
                for i in range(2):
                    test += str(tmp[i])
                answer += test
            elif tmp[3] == 3:
                for i in range(1):
                    test += str(tmp[i])
                answer += test

    if len(thousands) != 0:
        for thousand in thousands:
            answer += str(thousand)
    if len(zeros) != 0:
        if answer == '':
            answer += str(zeros[0][0])
        else:
            for zero in zeros:
                answer += str(zero[0])

    return answer

if __name__ == "__main__":
    numbers = [0, 0, 0]
    print(solution(numbers))