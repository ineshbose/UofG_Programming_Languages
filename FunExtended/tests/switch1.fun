# Test switch-commands.

proc main ():
    int s = 4
    switch s:
        case 1:
            s = 9
        case 4:
            s = 5
        default:
            s = 1
    .
    write(s)
.
