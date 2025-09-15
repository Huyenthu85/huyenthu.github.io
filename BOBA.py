n=int(input().strip());
for _ in range(n):
    s=input().strip();
    dem={};
    m=len(s);
    for i in range(m-2):
        a=s[i:i+3];
        dem[a]=dem.get(a,0)+1;
    if not dem:
        print(0);
    else:
        print(max(dem.values()));
        