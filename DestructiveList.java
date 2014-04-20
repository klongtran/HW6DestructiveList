public class DestructiveList<T>
	extends MyLinkedList<T>
{

    public DestructiveList() {
        super();
    }

    public void removeEvery(int number) {

        int baseLength, step;
        baseLength = size();
        step = number - 1;

        if (number == 1) {
            for (int i = 0; i < baseLength; i++) {
                remove(0);
            }
        }
        else {
            for (int i = number - 1; i < baseLength - (baseLength/number); i += step) {
                remove(i);
            }
        }
    }

    public void removeEvery(int number, int startingIndex) {
        int baseLength, step, limit;
        baseLength = size();
        step = number - 1;
        limit = (startingIndex + number - 1) + step*((baseLength - startingIndex)/number);

        if (number == 1) {
            for (int i = startingIndex; i < baseLength; i++) {
                remove(startingIndex);
            }
        }
        else {
            for (int i = startingIndex + number - 1;
                 i < limit;
                 i += step) {
                remove(i);
            }
        }
    }

    public int persistentlyRemoveGroupsOf(int size) {
        int groupsRemoved = 0;

        while (checkForGroupSize(size) > 0) {
            groupsRemoved += removeGroupsOf(size);
        }

        return groupsRemoved;
    }

    public int removeGroupsOf(int size) {
        int groupsRemoved = 0;
        int start = 0;
        int currentPosition = 0;
        int repeatCounter = 1;

        MyLinkedNode current = head;

        // --traverse the linked list
        while (current != null) {
            // check if the next value is a repeat
            if(get(currentPosition) == get(currentPosition+1)) {
                /* increase the repeat counter, continue traversing
                */
                repeatCounter++;
                current = current.next;
                currentPosition++;
            }
            /* if the next value is different, remove if repeatCounter equals size,
            reset the current position to the start position, reset the repeat counter.
            if the repeat counter is smaller than the size, continue traversing
            */
            else if (get(currentPosition) != get(currentPosition+1)) {
                if(repeatCounter >= size) {
                    // remove size times at the start
                    for(int i = 0; i < repeatCounter; i++) {
                        remove(start);
                    }
                    currentPosition = start;
                    repeatCounter = 1;
                    groupsRemoved++;
                }
                /* if the repeat counter is smaller than the size, reset the counter.
                Then continue traversing.
                */
                else if (repeatCounter < size) {
                    repeatCounter = 1;
                    current = current.next;
                    currentPosition++;
                    start = currentPosition;
                }
            }
        }

        return groupsRemoved;
    }

    public void rotate(int groupSize) {
        for (int i = 0; i < size() - groupSize + 1; i += groupSize) {
            add(i + groupSize - 1, get(i));
            remove(i);
        }
    }

    public int checkForGroupSize(int size) {
        int groupCounter = 0;
        int currentPosition = 0;
        int repeatCounter = 1;

        MyLinkedNode current = head;

        // --traverse the linked list
        while (current != null) {
            // check if the next value is a repeat
            if(get(currentPosition) == get(currentPosition+1)) {
                /* increase the repeat counter, continue traversing
                */
                repeatCounter++;
                current = current.next;
                currentPosition++;
            }
            /* if the next value is different, remove if repeatCounter equals size,
            reset the current position to the start position, reset the repeat counter.
            if the repeat counter is smaller than the size, continue traversing
            */
            else if (get(currentPosition) != get(currentPosition+1)) {
                if(repeatCounter >= size) {
                    groupCounter++;
                    repeatCounter = 1;
                }
                /* if the repeat counter is smaller than the size, reset the counter.
                Then continue traversing.
                */
                else if (repeatCounter < size) {
                    repeatCounter = 1;
                    current = current.next;
                    currentPosition++;
                }
            }
        }

        return groupCounter;
     }
}





