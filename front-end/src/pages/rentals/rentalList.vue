<template>
  <div class="d-flex flex-column align-items-center mt-5" style="height: 700px ">
    <h3 class="mb-2">대여 목록</h3>
    <div style="width:80%" >
      <div class="d-flex justify-content-end">
        <input type="text" class="form-control" v-model="selectBookname" placeholder="도서명" style="width:180px">
        <select class="form-select mx-3" style="width: 150px" v-model="selectStatus">
          <option value="">전체</option>
          <option value="rental">대여</option>
          <option value="return">반납</option>
        </select>
        <button type="button" class="btn btn-primary" @click.stop="SearchRentalList">검색</button>
      </div>
      <br>
      <div class="d-flex justify-content-center">
        <table class="table table-striped" >
          <thead>
            <tr>
              <th class="text-center" scope="col">No.</th>
              <th class="text-center" scope="col">회원명</th>
              <th class="text-center" scope="col">도서명</th>
              <th class="text-center" scope="col">대여상태</th>
              <th class="text-center" scope="col">반납</th>
              <th class="text-center" scope="col">대여 날짜</th>
              <th class="text-center" scope="col">반납 날짜</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="r in rentalList" v-bind:key="r">
              <td class="text-center">{{ r.rentalId }}</td>
              <td class="text-center">{{ r.memberId }}</td>
              <td class="text-center">{{ r.bookName }}</td>
              <td class="text-center">{{ r.rentalStatus }}</td>
              <td class="text-center">
                <div v-if="r.rentalStatus === 'RENTAL'">
                  <button type="button" class="btn btn-primary" @click.stop="bookReturn(r.rentalId)">도서 반납</button>
                </div>
                <div v-else>반납 완료</div>
              </td>
              <td class="text-center">{{ r.rentalDate }}</td>
              <td class="text-center">{{ r.returnDate }}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue';
import axios from '@/axiosBaseURL.js';

export default {
  setup() {     
    const selectBookname = ref('');
    const selectStatus = ref('');
    const rentalList = ref([]);

    const getRentalList = async () => {
        const res = await axios.get('/rental');
        rentalList.value = res.data;
    }
    getRentalList();

    const SearchRentalList = async () => {
      
      if(selectStatus.value === '' && selectBookname.value === '') {
        const res = await axios.get('/rental');
        rentalList.value = res.data;
      } else {
        const res = await axios.get(`/rental?book=${selectBookname.value}&status=${selectStatus.value}`);
        rentalList.value = res.data;
      } 
    }

    const bookReturn = async (rentalId) => {
      const res = await axios.put(`/rental/${rentalId}`);
      alert(res.data);
      getRentalList();
    }
        
    return {
      selectBookname,
      selectStatus,
      rentalList,
      getRentalList,
      SearchRentalList,
      bookReturn
    }

  }
}
</script>

<style>

</style>