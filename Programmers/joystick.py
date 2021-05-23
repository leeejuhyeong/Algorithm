def solution(name):
    result = 0
    # count alphabet translation
    for i in name:
        if ord(i) - 65 < 90 - ord(i):
            result += ord(i) - 65
        else:
            result += 90 - ord(i) + 1
    # count movement
    lcnt, rcnt=0,0
    for i in range(len(name)):
        if name[i] == "A": rcnt += 1
        else: rcnt = 0
        if name[-i] == "A": lcnt +=1
        else: lcnt = 0
    cnt = 0
    for i in range(len(name)//2):
        if name[i] == "A": cnt += 1
        else: cnt = 0
    res = 2*(len(name)//2-1-cnt)
    cnt = 0
    for i in range(len(name)//2, len(name)):
        if name[i] == "A": cnt +=1
        else: break
    res += len(name)-len(name)//2-cnt
    rresult = [res,len(name)-1-lcnt,len(name)-1-rcnt ]
    return min(rresult) + result


if __name__ == "__main__":
    name = "BBBAAAB"
    print(solution(name))