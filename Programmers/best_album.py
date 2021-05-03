def solution(genres, plays):
    one_hash = {}

    for i, j in zip(genres, plays):
        if i not in one_hash:
            one_hash[i] = j
        else:
            one_hash[i] += j

    save = sorted(one_hash.items(), key= lambda x:x[1], reverse=True)

    two_hash = {}

    for i in range(len(genres)):
        if genres[i] not in two_hash:
            two_hash[genres[i]] = [[i, plays[i]]]
        else:
            two_hash[genres[i]].append([i, plays[i]])

    answer = []

    for genre in save:
        x = sorted(two_hash[genre[0]], key = lambda x:(x[1], -x[0]), reverse=True)

        cnt = 0
        for i in x:
            if cnt == 2:
                cnt = 0
                break
            answer.append(i[0])
            cnt+=1

    return answer

if __name__ == "__main__":
   genres = ["classic", "pop", "classic", "classic", "pop"]
   plays = [500, 600, 150, 800, 2500]
   print(solution(genres, plays))