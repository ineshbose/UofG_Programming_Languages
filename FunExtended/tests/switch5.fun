# Test switch-commands.

func int test (int n):
    int r = 0
    int s = 0
    switch n:
        case 1:
            r = 1
            s = 2
        case 2..4:
            s = 3
        case 3:
            s = 2
        case 7:
            s = 5
        case 5..8:
            s = 4
        default:
            r = 4
    .
    write(s)
    return r
.

proc main ():
    write(test(1))
    write(test(3))
    write(test(5))
.
