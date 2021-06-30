<template>
  <div div class="d-flex flex-column align-items-center justify-content-center" style="height: 700px">
    <h3 class="mb-2">도서 등록</h3>
    <form style="width: 500px" @submit.stop.prevent="bookSave">
      <div class="my-3">
        <label for="" class="form-label">도서명</label>
        <input type="text" class="form-control" id="" placeholder="도서명을 입력해주세요" v-model="book.name">
      </div>
      <div class="my-3">
        <label for="inputAddress2" class="form-label">수량</label>
        <input type="text" class="form-control" id="inputAddress2" placeholder="수량을 입력해주세요" v-model="book.stockQuantity">
      </div>
      <div class="my-3">
        <label for="" class="form-label">도서 분류</label>
        <select id="" class="form-select" v-model="book.categoryName">
          <option v-for="c in categories" v-bind:key="c.id" :value="c.name">{{ c.name }}</option>
        </select>
      </div>
      <div class="my-3">
        <label for="inputAddress2" class="form-label">저자</label>
        <input type="text" class="form-control" id="inputAddress2" placeholder="저자를 입력해주세요" v-model="book.author">
      </div>
      <br>
      <div class="my-3 text-center">
        <button type="submit" class="btn btn-primary">도서 등록</button>
      </div>
    </form>
  </div>
</template>

<script>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import axios from '@/axiosBaseURL.js';

export default {
  setup() {
    const categories = ref([]);
    const book = ref([]);
    const router = useRouter();

    const getCategory = async () => {
      const res = await axios.get('/book/category');
      categories.value = res.data;
    }
    getCategory();
      
    const bookSave = async () => {
      const res = await axios.post('/book', {
        name: book.value.name,
        categoryName: book.value.categoryName,
        stockQuantity: book.value.stockQuantity,
        author: book.value.author
      })
      alert(res.data);
      router.push({
        name: 'Home'
      });
    }
    return {
      categories,
      book,
      getCategory,
      bookSave
    }

  }
}
</script>

<style>

</style>