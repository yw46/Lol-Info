import sqlite3

'''
/**
  * Created by Yishuo Wang on 07/31/2016
  * This script initializes databases (.db) with values from champion_list and item_list
  * All values in champion_list come from http://leagueoflegends.wikia.com/wiki/List_of_champions
  */
'''

# Removes space and special characters
def formatName(name):
    name = name.lower()
    nameLst = list(name)
    nameLst = [x for x in nameLst if x != ' ' and x != '\'' and x != '.']
    name = ''.join(nameLst)
    return name

# Helper function, split a string by '|' and return a tuple
def getinfo(tmp):
    return tuple(tmp.split('|'))
    

# Show commands
def showCommand(choice = True):
    print("---------------------------------------------------")
    if choice == True:
        print("| Main Page")
    print("| Command list")
    print("| 0. checkFiles")
    print("| 1. initializeDb -> lolchampinfo.db")
    print("| 2. initializeDb -> initializeDblolitemlist")
    print("| 3. initializeDb -> lolchampskill.db")
    print("| h. show help page")
    print("| q. quit")
    print("---------------------------------------------------")

# Debug function, make sure 'champion_list' and names from 'champInfo'
#   are identical
def checkFiles():
    #For Debug use only
    #----------
    #Check two files of champions are the same in terms of champion name
    fpc = open('champInfo', 'r')
    linesc = fpc.read().split('\n') #list of champions
    fpc.close()

    fp = open('champion_list', 'r')
    lines = fp.read().split('\n') #list of champions
    fp.close()

    if len(linesc) == len(lines) + 1:
        print("---Same length---")
    else:
        print("---Different length---")
        return
    
    im = len(lines)
    for i in range(0, im):
        tup = getinfo(linesc[i+1])
        if tup[0] != lines[i]:
            print("- false, champion name not same at line (champion_list)", i+1, "\n    champion name:", tup[0])
        del tup
    #----------
    return

# Initialize database with information form 'champInfo'
def initializeDblolchampinfo():
    lastchamp = ''
    try:
        ###CHAMPION LIST###
        fp = open('champInfo', 'r')
        lines = fp.read().split('\n') #list of champions
        fp.close()
    except FileNotFoundError as e:
        print(e)
        return
    except:
        print("Unknown error occured")
        return
    newLst = [] #list of champions with space and special characters removed
    for line in lines:
        newLst.append(formatName(line))

    ###SQLite###
    sqliteFile = 'lolchampinfo.db'
    conn = sqlite3.connect(sqliteFile)
    cur = conn.cursor()
    
    #clear table
    cur.executescript("""
        DROP TABLE IF EXISTS LOLCHAMPINFO;
        CREATE TABLE LOLCHAMPINFO(
            name TEXT,
            thumbnail BLOB,
            primary_role TEXT,
            secondary_role TEXT,
            title TEXT,
            nation TEXT,
            attack INTEGER,
            defense INTEGER,
            ability INTEGER,
            diff INTEGER,
            date TEXT,
            ip INTEGER,
            rp INTEGER,
            PRIMARY KEY(name));
        """)
    #insert values
    i = -1
    errornum = 0
    for line in lines:
        if line == '':
            continue
        if i == -1:
            i += 1
            continue
        if line[0] == '\n':
            line = line[1:]
        tup = getinfo(line)

        #get image file
        #champion_square
        imageName = "../res/drawable/" + "champ_" + formatName(tup[0]) + "_square.png"
        try:
            f_image = open(imageName, 'rb')
            image = f_image.read()
            f_image.close()
        except FileNotFoundError:
            print("File not found: ", imageName, ", Champion: ", tup[0], ", lastchamp: ", lastchamp, sep = '')
            try:
                f_image = open("champion_square.png", 'rb')
                image = f_image.read()
                f_image.close()
            except:
                print("Error loading image 0: champion_square")
                image = 'null'
        except:
            print("Error loading image 1:", imageName)
            image = 'null'
        #cur.setinputsizes(photo = sqlite3.BLOB)

        try:
            cur.execute("""
                INSERT INTO LOLCHAMPINFO VALUES(
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?);
                """, (tup[0],image,tup[1],tup[2],tup[3],tup[4],tup[5],tup[6],tup[7],tup[8],tup[9],tup[10],tup[11],))
        except:
            print("\n--------------\nError executing sql\n", line, "\ni: ", i, "\nError message done\n-------------\n", sep = '')
            errornum += 1
        i += 1
        lastchamp = tup[0]
    print("Total value inserted:", i, "\nError:", errornum)
    conn.commit()
    
    cur.close()
    conn.close()
    return

def lolchampskill():
    lastitem = ''
    try:
        ###CHAMPION LIST###
        fp = open('champSkill', 'r')
        lines = fp.read().split('=')
        fp.close()
    except FileNotFoundError as e:
        print(e)
        return
    except:
        print("Unknown error occured")
        return
    ###SQLite###
    sqliteFile = 'lolchampskill.db'
    conn = sqlite3.connect(sqliteFile)
    cur = conn.cursor()

    #clear table
    cur.executescript("""
        DROP TABLE IF EXISTS LOLCHAMPSKILL;
        CREATE TABLE LOLCHAMPSKILL(
            champ TEXT,
            pname TEXT,
            p TEXT,
            pthumbnail BLOB,
            qname TEXT,
            q TEXT,
            qthumbnail BLOB,
            wname TEXT,
            w TEXT,
            wthumbnail BLOB,
            ename TEXT,
            e TEXT,
            ethumbnail BLOB,
            rname TEXT,
            r,
            rthumbnail BLOB,
            PRIMARY KEY(champ));
        """)

    #insert values
    i = -1
    errornum = 0
    for line in lines:
        if line == '':
            continue
        if i == -1:
            i += 1
            continue
        if line[0] == '\n':
            line = line[1:]
        #print("+++++", line, "+++++", sep = '')
        tup = getinfo(line)
        #get image file
        f_image = open("skill_icon/"+tup[0]+"P.png", 'rb')
        imageP = f_image.read()
        f_image.close()
        f_image = open("skill_icon/"+tup[0]+"Q.png", 'rb')
        imageQ = f_image.read()
        f_image.close()
        f_image = open("skill_icon/"+tup[0]+"W.png", 'rb')
        imageW = f_image.read()
        f_image.close()
        f_image = open("skill_icon/"+tup[0]+"E.png", 'rb')
        imageE = f_image.read()
        f_image.close()
        f_image = open("skill_icon/"+tup[0]+"R.png", 'rb')
        imageR = f_image.read()
        f_image.close()
        try:
            cur.execute("""
                INSERT INTO LOLCHAMPSKILL VALUES(
                ?,
                ?,
                ?,
                ?,
                ?,
                ?,
                ?,
                ?,
                ?,
                ?,
                ?,
                ?,
                ?,
                ?,
                ?,
                ?);
            """, (tup[0], tup[1], tup[2], imageP, tup[3], tup[4], imageQ, tup[5], tup[6], imageW, tup[7], tup[8], imageE, tup[9], tup[10], imageR,))
        except:
            print("\n--------------\nError executing sql\n", line, "\ni: ", i, "\nError message done\n-------------\n", sep = '')
            errornum += 1
        i += 1
        lastitem = tup[0]
    print("Total value inserted:", i,"\nError:", errornum)
    conn.commit()
    cur.close()
    conn.close()
    return

# Initialize database with information form 'item_list'
# For now using 'test' for test
def initializeDblolitemlist():
    lastitem = ''
    try:
        ###CHAMPION LIST###
        fp = open('test', 'r')
        lines = fp.read().split('=')
        fp.close()
    except FileNotFoundError as e:
        print(e)
        return
    except:
        print("Unknown error occured")
        return

    ###SQLite###
    sqliteFile = 'loliteminfo.db'
    conn = sqlite3.connect(sqliteFile)
    cur = conn.cursor()
    
    #clear table
    cur.executescript("""
        DROP TABLE IF EXISTS LOLITEMINFO;
        CREATE TABLE LOLITEMINFO(
            name TEXT,
            thumbnail BLOB,
            category TEXT,
            sr INTEGER,
            tt INTEGER,
            mb INTEGER,
            gold INTEGER,
            recipe TEXT,
            note TEXT,
            PRIMARY KEY(name));
        """)

    #insert values
    i = -1
    errornum = 0
    for line in lines:
        
        if line == '':
            continue
        if i == -1:
            i += 1
            continue
        if line[0] == '\n':
            line = line[1:]
        #print("+++++", line, "+++++", sep = '')
        tup = getinfo(line)

        #get image file
        #champion_square
        imageName = "champion_square"
        f_image = open("item_icon/sight_ward_item.png", 'rb')
        image = f_image.read()
        f_image.close()
        '''
        #get image file
        #champion_square
        imageName = "../res/drawable/" + "champ_" + formatName(tup[0]) + "_square.png"
        try:
            f_image = open(imageName, 'rb')
            image = f_image.read()
            f_image.close()
        except FileNotFoundError:
            print("File not found: ", imageName, ", Champion: ", tup[0], ", lastchamp: ", lastchamp, sep = '')
            try:
                f_image = open("champion_square.png", 'rb')
                image = f_image.read()
                f_image.close()
            except:
                print("Error loading image 0: champion_square")
                image = 'null'
        except:
            print("Error loading image 1:", imageName)
            image = 'null'
        #cur.setinputsizes(photo = sqlite3.BLOB)
        '''
        try:
            cur.execute("""
                INSERT INTO LOLITEMINFO VALUES(
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?);
                """, (tup[0], image, tup[1], tup[2], tup[3], tup[4], tup[5], tup[6], tup[7],))
        except:
            print("\n--------------\nError executing sql\n", line, "\ni: ", i, "\nError message done\n-------------\n", sep = '')
            errornum += 1
            #print("Error execute sql:", i)

        i += 1
        lastitem = tup[0]
    print("Total value inserted:", i,"\nError:", errornum)
    conn.commit()

    cur.close()
    conn.close()
    return

# Main function
def main():
    showCommand()
    i = 0
    while True:
        inp = input("Enter choice ->")
        if inp == '0':
            checkFiles()
            print("\n\n")
            showCommand()
            i = 0
        elif inp == '1':
            initializeDblolchampinfo()
            print("\n\n")
            showCommand()
            i = 0
        elif inp == '2':
            initializeDblolitemlist()
            print("\n\n")
            showCommand()
            i = 0
        elif inp == '3':
            lolchampskill()
            print("\n\n")
            showCommand()
            i = 0
        elif inp == 't':
            test()
            i = 0
        elif inp == 'h':
            showCommand(False)
            i = 0
        elif inp == 'q':
            return
        elif inp == '':
            i += 1
            if i == 3:
                return
    return

def test():
    aaa = "This|is a \n new|line\ntest"
    lst = list(tuple(aaa.split('|')))
    print(lst)
    print('-----')
    n = len(lst)
    for i in range(n):
        if '\n' in lst[i]:
            m = len(lst[i])
            s = lst[i].find('\n')
            tmp = lst[i][:s] + ' CHAR(13) + CHAR(10) '
            if s < m-2:
                tmp += lst[i][s+1:]
            lst[i] = tmp
    print(tuple(lst))
    return


if __name__ == "__main__":
    main()
