import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MaxHeap
{
    List<Integer> list;
    int size;
    public MaxHeap()
    {
        this.list = new ArrayList<Integer>();
    }
    public int left(int i)
    {
        return this.list.get(2 * i + 1);
    }
    public int right(int i)
    {
        return this.list.get(2 * i + 2);
    }
    public int parent(int i)
    {
        return this.list.get((i - 1)/ 2);
    }

    public void maxHeapify(int i)
    {
        int l = this.left(i);
        int r = this.right(i);
        int large = i;
        if(l < this.size && (this.list.get(large) < this.list.get(l)))
        {
            large = l;
        }
        if(r < this.size && (this.list.get(large) < this.list.get(r)))
        {
            large = r;
        }
        if(large != i)
        {
            Collections.swap(list, large, i);
            maxHeapify(large);
        }
    }


    public void buildMaxHeap()
    {
        int i = (this.size / 2) - 1;
        for(; i >= 0; --i)
        {
            this.maxHeapify(i);
        }
    }

    public void insert(int element)
    {
        this.list.add(element);
        ++this.size;
        int index = this.size - 1;
        int p = this.parent(index);
        while(index > 0 && this.list.get(p) < this.list.get(index))
        {
            Collections.swap(this.list, p, index);
            index = this.parent(index);
            p = this.parent(index);
        }
    }

    public int getMax()
    {
        return this.list.get(0);
    }

    public void extractMax()
    {
        Collections.swap(this.list, 0, this.size - 1);
        --this.size;
        maxHeapify(0);
    }

    public void increaseKey(int index, int newValue)
    {
        if(newValue <= this.list.get(index))
        {
            throw new RuntimeException("Invalid");
        }
        this.list.set(index, newValue);
        int tempIndex = index;
        int p = this.parent(index);
        while(tempIndex > 0 && this.list.get(tempIndex) > this.list.get(p))
        {
            Collections.swap(this.list, tempIndex, p);
            tempIndex = this.parent(tempIndex);
            p = this.parent(tempIndex);
        }
    }

}






public class Main
{
    public static void main(String[] args)
    {

    }
}