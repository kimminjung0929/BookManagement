<template>
  <div class="d-flex flex-column align-items-center mt-5" style="height: 700px ">
    <h3 class="mb-2">도서 목록</h3>
    <br>
    <div style="width:80%" >
      <div class="d-flex justify-content-end">
        <input type="text" class="form-control mx-2" v-model="search" placeholder="목록을 입력해주세요" style="width:200px" @keyup.up.enter="searchCategory">
        <button type="button" class="btn btn-primary" @click.stop="searchCategory">검색</button>
      </div>
      <br>
      <div class="d-flex justify-content-center">
        <table class="table table-striped" >
          <thead>
            <tr>
              <th class="text-center" scope="col">#</th>
              <th class="text-center" scope="col">도서명</th>
              <th class="text-center" scope="col">재고</th>
              <th class="text-center" scope="col">분류</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="book in books" v-bind:key="book.id">
              <td class="text-center">{{ book.id }}</td>
              <td class="text-center">{{ book.name }}</td>
              <td class="text-center">{{ book.stockQuantity }}</td>
              <td class="text-center">{{ book.categoryName }}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
    <div v-if="!books.length" style="color: red">도서가 없습니다</div>
  </div>
</template>

<script>
import { ref } from 'vue';
import axios from '@/axiosBaseURL.js';

export default {
    setup() {
      const books = ref([]);
      const search = ref ('');

      const getBook = async () => {
        const res = await axios.get('/book');
        books.value = res.data;
      }
      getBook();

      const searchCategory = async () => {
        if (search.value === '') {
          getBook();
        }
        const res = await axios.get(`book?category=${search.value}`);
        books.value = res.data;
      }
        
      return {
        books,
        search,
        getBook,
        searchCategory
      }

    }
}
</script>

<style>

</style>