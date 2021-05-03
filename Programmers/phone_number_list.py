def solution(phone_book):

    hash_phone = {}
    for i in phone_book:
        hash_phone[i] = True

    for i in phone_book:
        temp = ""
        for j in i:
            temp += j
            if temp in hash_phone and i != temp:
                return False
    return True

if __name__ == "__main__":
    phone_book = ["12","123","1235","567","88"]

    print(solution(phone_book))