<template>
  <div class="d-flex flex-column align-items-center justify-content-center" style="height: 700px">
    <h2>도서 대여 서비스</h2>
    <br>
    <div>회원 기능</div>
    <div>
      <router-link type="button" class="btn btn-primary mx-3 my-1" v-bind:to="{name: 'MemberRegister'}">회원 등록</router-link>
      <router-link type="button" class="btn btn-primary mx-3 my-1" v-bind:to="{name: 'MemberList'}">회원 목록</router-link>
    </div>
    <div>도서 기능</div>
    <div>
      <router-link type="button" class="btn btn-primary mx-3 my-1" v-bind:to="{name: 'BookRegister'}">도서 등록</router-link>
      <router-link type="button" class="btn btn-primary mx-3 my-1" v-bind:to="{name: 'BookList'}">도서 목록</router-link>
    </div>
    <div>대여 기능</div>
    <div>
      <router-link type="button" class="btn btn-primary mx-3 my-1" v-bind:to="{name: 'RentalRegister'}">도서 대여</router-link>
      <router-link type="button" class="btn btn-primary mx-3 my-1" v-bind:to="{name: 'RentalList'}">대여 목록</router-link>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>