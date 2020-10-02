
d = 1000
for x in range(d):
    for y in reversed(range(d)):
        print(str(x) + "|" + str(y))
    print(str(x) + "|" + str(int(d/2)))
