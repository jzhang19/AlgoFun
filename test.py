
from winreg import QueryReflectionKey
from editor import Editor

class Test:

    def main():
        editor = Editor()
        
        queries1 = []
        queries1.append([ "APPEND", "Hey" ])
        queries1.append([ "APPEND", " you" ])
        queries1.append([ "APPEND", " don't" ])
        queries1.append([ "APPEND", " " ])
        queries1.append([ "APPEND", "let me down" ])
        editor.run(queries1)
        
        queries2 = []
        queries2.append([ "APPEND", "Hey, you!" ])
        queries2.append([ "BACKSPACE" ])
        queries2.append([ "APPEND", "? Impossibe1!" ])
        queries2.append([ "BACKSPACE" ])
        queries2.append([ "BACKSPACE" ])
        queries2.append([ "BACKSPACE" ])
        queries2.append([ "APPEND", "1e!" ])
        editor.run(queries2)
        
        queries3 = []
        queries3.append([ "APPEND", "Hey you!" ])
        queries3.append([ "MOVE", "3" ])
        queries3.append([ "APPEND", "," ])
        editor.run(queries3)

        queries4 = []
        queries4.append([ "APPEND", "Hello cruel world!" ])
        queries4.append([ "SELECT", "5", "11" ])
        queries4.append([ "APPEND", "," ])
        queries4.append([ "SELECT", "5", "12" ])
        queries4.append([ "BACKSPACE" ])
        queries4.append([ "SELECT", "4", "6" ])
        queries4.append([ "MOVE", "1" ])
        editor.run(queries4)

        queries5 = []
        queries5.append([ "APPEND", "Hello, world!" ])
        queries5.append([ "SELECT", "5", "12" ])
        queries5.append([ "COPY", "," ])
        queries5.append([ "MOVE", "12" ])
        queries5.append([ "PASTE" ])
        queries5.append([ "PASTE" ])
        queries5.append([ "SELECT", "5", "19" ])
        queries5.append([ "PASTE" ])
        editor.run(queries5)
        
    if __name__ == "__main__":
        main()
