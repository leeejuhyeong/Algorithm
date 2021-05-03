def solution(clothes):
    hash_mtrix = {}

    for i in clothes:
        if i[1] not in hash_mtrix:
            hash_mtrix[i[1]] = [i[0]]
        else:
            hash_mtrix[i[1]].append(i[0])

    temp = 1
    for i in hash_mtrix.values():
        temp *= len(i)+1

    return temp-1

if __name__ == "__main__":
   clothes = [["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]
   print(solution(clothes))