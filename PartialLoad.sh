echo "Partial load script started"
echo ""

FILE="./isRunninTest.txt"
if [ -f "$FILE" ]; then
echo "file '$FILE' exists"
echo "exiting"
else
echo "starting java program"
touch $FILE
java -jar PartialLoad.jar "testfile.txt" "http://127.0.0.1:8000/partial/edit" || rm $FILE
rm $FILE
fi